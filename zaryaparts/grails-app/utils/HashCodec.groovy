import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

class HashCodec {
	static encode = {str ->
		MessageDigest md = MessageDigest.getInstance('SHA-512')
		md.update(str.getBytes('UTF-8'))
		return Base64.encodeBase64String(md.digest())
	}
}