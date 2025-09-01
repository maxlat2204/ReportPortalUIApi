package praktikum.dashboard;

import praktikum.EnvConfig;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardModel {

    private String description;
    private String name;

    public static DashboardModel random(){
        return new DashboardModel(EnvConfig.DASHBOARD_DESCRIPTION, EnvConfig.DASHBOARD_NAME);
    }

}

