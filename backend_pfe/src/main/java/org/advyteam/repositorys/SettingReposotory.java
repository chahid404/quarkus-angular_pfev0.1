package org.advyteam.repositorys;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Setting;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SettingReposotory implements PanacheRepositoryBase<Setting,Long> {
}
