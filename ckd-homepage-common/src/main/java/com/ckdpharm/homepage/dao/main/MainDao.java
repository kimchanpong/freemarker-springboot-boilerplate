package com.ckdpharm.homepage.dao.main;

import static com.ckdpharm.jooq.domain.Tables.AUTHOR;
import com.ckdpharm.homepage.dao.common.BaseDao;
import com.ckdpharm.homepage.model.main.MainVO;
import com.ckdpharm.jooq.domain.tables.records.AuthorRecord;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainDao extends BaseDao {
    public List<MainVO> selectMain() {
        List<MainVO> resultList = null;
//        Result<AuthorRecord> result = dao.selectFrom(AUTHOR).fetch();
        List<MainVO> result = dao.selectFrom(AUTHOR).fetchInto(MainVO.class);
        return result;
    }
}
