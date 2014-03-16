/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import com.google.common.base.Charsets;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author qfdk
 */
public  class String2Utf8 {
    
    public static String converterString(String str) throws UnsupportedEncodingException
    {
        String tmp=new String(str.getBytes(Charsets.ISO_8859_1),Charsets.UTF_8);
        return tmp;
    }
}
