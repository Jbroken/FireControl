package com.fire.dao;

import com.fire.po.Troubletable;
import com.fire.po.TroubletableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TroubletableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int countByExample(TroubletableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int deleteByExample(TroubletableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int deleteByPrimaryKey(Integer troubletableid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int insert(Troubletable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int insertSelective(Troubletable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    List<Troubletable> selectByExample(TroubletableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    Troubletable selectByPrimaryKey(Integer troubletableid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") Troubletable record, @Param("example") TroubletableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int updateByExample(@Param("record") Troubletable record, @Param("example") TroubletableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int updateByPrimaryKeySelective(Troubletable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table troubletable
     *
     * @mbggenerated Sat Oct 08 15:37:59 CST 2016
     */
    int updateByPrimaryKey(Troubletable record);
}