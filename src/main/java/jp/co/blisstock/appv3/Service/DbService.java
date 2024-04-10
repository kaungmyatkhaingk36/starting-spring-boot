package jp.co.blisstock.appv3.Service;

import org.springframework.stereotype.Service;
import jp.co.blisstock.appv3.FormData;
import jp.co.blisstock.appv3.ProfileRepo;
import jp.co.blisstock.appv3.Model.Profile;

@Service
public class DbService {
    ProfileRepo profileRepo;

    public DbService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public void saveInfo(FormData formData) {
        Profile profile = new Profile();

        profile.setName(formData.getName());
        profile.setAge(formData.getAge());
        profile.setGender(formData.getGender());
        profile.setOccupation(formData.getOccupation());
        profile.setEmail(formData.getEmail());
        profileRepo.save(profile);
    }

    public Profile getInfo(String name) {
        return profileRepo.findByName(name);
    }
}
