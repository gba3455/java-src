package pkgfinalproject.pkgutils;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Set;

public class MyCharSet extends Charset{

	protected MyCharSet(String canonicalName, String[] aliases) {
		super(canonicalName, aliases);
		// TODO Auto-generated constructor stub
	}
	public static Set getCharset(){
		String[] strArr = {"US-ASCII","EUC-JP","GB18030","GB2312","GBK","ISO-2022-JP","Shift_JIS","UTF-8"};
		MyCharSet mcs = new MyCharSet("str",strArr);
		return mcs.aliases();
	}
	@Override
	public boolean contains(Charset cs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CharsetDecoder newDecoder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharsetEncoder newEncoder() {
		// TODO Auto-generated method stub
		return null;
	}

}
