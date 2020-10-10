### FXF ~ Antena Injector
Cheat antena view anti banned for Free Fire Game.Support latest version Free Fire.The features just character with antena head,character with antena hand and normal character.No other cheat.Safe for your main account.

Work on no root device.Required internet connection.If there is no internet connection, the app doesn't work.
if you have any questions contact us: cs.kinderboy@gmail.com

**Note:**
If you want to fork this repo:
Use encrypt with this following code:

``` java
import com.bay.fxf.lib.Decryptor;

public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            Decryptor.setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {

        }
        return null;
    }
```
