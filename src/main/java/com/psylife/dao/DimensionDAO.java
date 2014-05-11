package com.psylife.dao;

import java.util.List;
import com.psylife.entity.DimensionEntity;

public interface DimensionDAO {
	/**
	 * 查询评分标准
	 * @param companyUser
	 * @return
	 */
	public DimensionEntity queryDimensionByQid(DimensionEntity dim);
}
