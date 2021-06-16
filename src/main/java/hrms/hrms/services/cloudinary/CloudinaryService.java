package hrms.hrms.services.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryService {
	static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dfx7p5jvm",
			"api_key", "831656927796817",
			"api_secret", "vqkXIaHU9H7BcfGfGPyln5gQuF4"));
	
	public static String uploadImage(String Url) throws IOException {
		File file = new File(Url);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		return (String) uploadResult.get("url");
	}
}
