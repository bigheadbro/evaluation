package com.psylife.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.psylife.common.Constant;

public class QuestionUtil {

	public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static NodeList selectNodes(String express, Object source) {//查找节点，返回符合条件的节点集。
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static NodeList getQuestions()
    {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	NodeList questions = null;
		Element root = null;
		try 
		{
			DocumentBuilder db=factory.newDocumentBuilder();
            Document xmldoc=db.parse(new File("QPool/QList.xml"));
            root=xmldoc.getDocumentElement();
            questions = selectNodes("/questions/question", root);
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		} 
		catch (SAXException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return questions;
    }
    
    public static NodeList getChildQuestions()
    {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	NodeList questions = null;
		Element root = null;
		try 
		{
			DocumentBuilder db=factory.newDocumentBuilder();
            Document xmldoc=db.parse(new File("QPool/QList.xml"));
            root=xmldoc.getDocumentElement();
            questions = selectNodes("/questions/cq", root);
		} 
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		} 
		catch (SAXException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return questions;
    }
    
    public static NodeList getTopAnswers(Element question)
    {
    	NodeList answers = null;
    	NodeList questionChild = question.getChildNodes();
		for(int i = 0; i < questionChild.getLength();i++)
		{
			if(questionChild.item(i).getNodeName().contains("answers"))
			{
				Element answersEl = (Element)questionChild.item(i);
				answers = answersEl.getElementsByTagName("answer");
			}
		}
		return answers;
    }
    
    public static String getTitle(Element question)
    {
    	String title = "";
    	NodeList questionChild = question.getChildNodes();
		for(int i = 0; i < questionChild.getLength();i++)
		{
			if(questionChild.item(i).getNodeName().contains("title"))
			{
				Element element = (Element)questionChild.item(i);
				return element.getFirstChild().getTextContent();
			}
		}
		return title;
    }
    
	public static void main(String[] args) 
	{
		NodeList questions = getQuestions();
		int qLen = questions.getLength();
		for(int i=0;i<qLen;i++)
		{
			Element question = (Element)questions.item(i);
			System.out.println(getTitle(question));
			NodeList answers = getTopAnswers(question);
			for(int j = 0;j<answers.getLength();j++)
			{
				Element tmp = (Element)(answers.item(j));
				System.out.println(tmp.getTextContent() + ":" + tmp.getAttribute("go"));
			}
		}
		
		NodeList cq = getChildQuestions();
		for(int i=0;i<cq.getLength();i++)
		{
			Element question = (Element)cq.item(i);
			System.out.println(getTitle(question));
			NodeList answers = getTopAnswers(question);
			for(int j = 0;j<answers.getLength();j++)
			{
				Element tmp = (Element)(answers.item(j));
				System.out.println(tmp.getTextContent() + ":" + tmp.getAttribute("go"));
			}
		}
		
		

	}

}
