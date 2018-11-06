package com.ckdpharm.homepage.dao.main;

import com.ckdpharm.homepage.dao.common.BaseDao;
import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
import com.ckdpharm.homepage.model.main.MainVO;
import com.ckdpharm.jooq.domain.tables.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainDao extends BaseDao {
    private Author author = Author.AUTHOR;

    public List<MainVO> selectList() {
        return dao
                .selectFrom(author)
                .fetchInto(MainVO.class);
    }

    public MainVO selectVo(MainSO so) {
        return dao
                .select()
                .from(author)
                .where(author.ID.eq(so.getId()))
                .fetchAny().into(MainVO.class);
    }

    public int insertVo(MainPO po) {
        /** insertInto의 첫번째 인자는 무조건 테이블 domain이 와야한다 */
        return dao
                .insertInto(author, author.ID, author.FIRST_NAME, author.LAST_NAME)
                .values(po.getId(), po.getFirstName(), po.getLastName())
                .execute();
    }

    public int updateVo(MainPO po) {
        /** update의 첫번째 인자는 무조건 테이블 domain이 와야한다 */
        return dao
                .update(author)
                .set(author.FIRST_NAME, po.getFirstName())
                .set(author.LAST_NAME, po.getLastName())
                .where(author.ID.eq(po.getId()))
                .execute()
                ;
    }
}
