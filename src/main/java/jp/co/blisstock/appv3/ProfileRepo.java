package jp.co.blisstock.appv3;

import org.springframework.data.repository.CrudRepository;

import jp.co.blisstock.appv3.Model.Profile;

public interface ProfileRepo extends CrudRepository<Profile, String> {
    public Profile findByName(String name);
}
