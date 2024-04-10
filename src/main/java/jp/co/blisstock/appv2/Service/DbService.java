package jp.co.blisstock.appv2.Service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import jp.co.blisstock.appv2.FormData;
import jp.co.blisstock.appv2.ProfileRepo;
import jp.co.blisstock.appv2.Model.Profile;

@Service
public class DbService {
    ProfileRepo profileRepo;

    public DbService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public void saveInfo(FormData formData) throws SQLException {
        String query = String.format("INSERT INTO person_profile values (\"%s\", %d, \"%s\", \"%s\", \"%s\");",
                formData.getName(),
                formData.getAge(), formData.getGender(), formData.getOccupation(), formData.getEmail());
        profileRepo.saveProfile(query);
    }

    public Profile getInfo(String name) throws SQLException {
        String query = String.format("SELECT * FROM person_profile WHERE name=\"%s\"", name);
        return profileRepo.getProfile(query);
    }
}
