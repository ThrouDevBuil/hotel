package br.com.guacom.hotel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {
	public static final String IDIOM = "pt";
	public static final String COUNTRY = "br";
	public static final String COIN = "R$";
	
	public static final String formatBr(BigDecimal preco) {
		NumberFormat formatBr = DecimalFormat.getCurrencyInstance(new Locale(MoedaUtil.IDIOM, MoedaUtil.COUNTRY));
		return formatBr.format(preco);
	}
	
}
