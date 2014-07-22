package com.psylife.dao;

import com.psylife.entity.ScoreEntity;

public interface ScoreDAO {
	/**
	 * 查询评分标准
	 * @param companyUser
	 * @return
	 */
	public ScoreEntity queryScoreByUserid(int userid);
}
