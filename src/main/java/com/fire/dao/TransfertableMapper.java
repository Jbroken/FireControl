package com.fire.dao;

import com.fire.po.Transfertable;
import com.fire.po.TransfertableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransfertableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int countByExample(TransfertableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int deleteByExample(TransfertableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int deleteByPrimaryKey(Integer transfertableid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int insert(Transfertable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int insertSelective(Transfertable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    List<Transfertable> selectByExample(TransfertableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    Transfertable selectByPrimaryKey(Integer transfertableid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int updateByExampleSelective(@Param("record") Transfertable record, @Param("example") TransfertableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int updateByExample(@Param("record") Transfertable record, @Param("example") TransfertableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int updateByPrimaryKeySelective(Transfertable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfertable
     *
     * @mbggenerated Sun Oct 09 18:00:05 CST 2016
     */
    int updateByPrimaryKey(Transfertable record);
}