package tomyjan.moeclassroommanager.common.base.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.dto.BaseDomain;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;

import java.util.List;

/**
 * 基础service
 *
 * @param <T>
 */
public interface BaseService<T extends BaseDomain> {

    /**
     * 分页
     *
     * @param dto
     *
     * @return
     */
    PageInfo<T> selectPage(T dto);

    /**
     * 分页
     *
     * @param condition
     *
     * @return
     */
    PageInfo<T> selectPage(MybatisCondition condition);

    /**
     * 更新或者保存
     *
     * @param dto
     *
     * @return
     */
    int merge(T dto);

    /**
     * 判断是否存在
     *
     * @param condition
     *
     * @return
     */
    boolean isExist(MybatisCondition condition);

    /**
     * 通过主键查看
     *
     * @param id
     *
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 通过添加查找
     *
     * @param obj
     *
     * @return
     */
    List<T> select(T obj);

    /**
     * 通过主键删除
     *
     * @param id
     *
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过条件查找数量
     *
     * @param t
     *
     * @return
     */
    Integer selectCount(T t);

    /**
     * 根据条件更新
     *
     * @param t
     *
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 查找全部
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 插入
     *
     * @param t
     *
     * @return
     */
    int insertSelective(T t);
}
