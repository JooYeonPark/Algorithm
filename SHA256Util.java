public class SHA256Util {
	
	public static String hashing(String password) throws Exception {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
		//1. digest로 256비트 = 32바이트로 hash에 저장한다.
		byte[] hash = digest.digest(password.getBytes("UTF-8"));
		
		//2.이쁘게 만들어야지! 어떻게 이쁘게 만들어줄것인가?
		//-128~127 이렇게 나오니까
		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
	
}
