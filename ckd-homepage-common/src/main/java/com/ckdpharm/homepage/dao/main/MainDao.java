package com.ckdpharm.homepage.dao.main;

import com.ckdpharm.homepage.dao.common.BaseDao;
import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
import com.ckdpharm.homepage.model.main.MainVO;
import org.springframework.stereotype.Repository;


import java.util.List;

import static com.ckdpharm.jooq.domain.tables.Author.AUTHOR;

@Repository
public class MainDao extends BaseDao {

    public List<MainVO> selectList() {
        return dao
                .selectFrom(AUTHOR)
                .fetchInto(MainVO.class);
    }

    public MainVO selectVo(MainSO so) {
        return dao
                .select()
                .from(AUTHOR)
                .where(AUTHOR.ID.eq(so.getId()))
                .fetchAny().into(MainVO.class);
    }

    public int insertVo(MainPO po) {
        /** insertInto의 첫번째 인자는 무조건 테이블 domain이 와야한다 */
        return dao
                .insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .values(po.getId(), po.getFirstName(), po.getLastName())
                .execute();
    }

    public int updateVo(MainPO po) {
        /** update의 첫번째 인자는 무조건 테이블 domain이 와야한다 */
        return dao
                .update(AUTHOR)
                .set(AUTHOR.FIRST_NAME, po.getFirstName())
                .set(AUTHOR.LAST_NAME, po.getLastName())
                .where(AUTHOR.ID.eq(po.getId()))
                .execute()
                ;
    }
}
