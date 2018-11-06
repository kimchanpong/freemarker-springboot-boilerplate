package com.ckdpharm.homepage.model.main;

import com.ckdpharm.homepage.model.common.BaseSearchVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainSO extends BaseSearchVO<MainSO> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;
}
