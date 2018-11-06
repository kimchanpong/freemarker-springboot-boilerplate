package com.ckdpharm.homepage.model.main;

import com.ckdpharm.homepage.model.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainVO extends BaseModel<MainVO> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;

    @Override public String toString() {
        return "MainVO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
