package com.fire.dao;

import com.fire.po.Picture;
import com.fire.po.PictureExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int countByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int deleteByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int deleteByPrimaryKey(Integer pictureid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int insert(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int insertSelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    List<Picture> selectByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    Picture selectByPrimaryKey(Integer pictureid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int updateByPrimaryKeySelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbggenerated Thu Nov 24 21:35:51 CST 2016
     */
    int updateByPrimaryKey(Picture record);

    @Select("select * from picture where firetableid = #{firetableid}")
	List<Picture> findPictureById(String firetableid);
}