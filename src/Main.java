import com.daredo.utils.SecurityUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {


        String content  = "{\n" +
                "  \"libCommons\": {\n" +
                "    \"RemoteConfig\": {\n" +
                "      \"PlistFile\": \"config_test/RemoteConfig.plist\",\n" +
                "      \"PlistUrl\": \"https://ihandysoftdevelop.s3.amazonaws.com/apptemplate_android/configs/RemoteConfig.pa\",\n" +
                "      \"PlistServerEnabled\": true,\n" +
                "      \"PlistServerSigKey\": \"1\",\n" +
                "      \"PlistServerHashKey\": \"`weqA#rR(C*TUE$$f;<,GoH7QTne<;<C\",\n" +
                "      \"plistParseWithStream\": true,\n" +
                "      \"UpdateInterval\": 90\n" +
                "    },\n" +
                "    \"Analytics\": {\n" +
                "      \"FlurryKey\": \"2TWRDHSXZN5CQ8R4MT9D\",\n" +
                "      \"FacebookID\": \"FacebookID\",\n" +
                "      \"TapjoySDKKey\": \"TsXCLSBVQ4K_O1n0KPI5bgECITA3vkCezh8m8FHcvwnRtpXGF_ZFvbiBpcG\",\n" +
                "      \"FlyerKey\": \"d4VKN2yBPk7gqTRBZcwkbc\",\n" +
                "      \"FlyerSendProbability\": 100,\n" +
                "      \"FlyerEvents\": [\n" +
                "        \"test_appParam_param1\",\n" +
                "        \"test_appParam_param2\"\n" +
                "      ],\n" +
                "      \"FlurryStoredMaxCount\": 1000,\n" +
                "      \"GoogleTrackId\": \"UA-xxxxxx-x\",\n" +
                "      \"GooglePercentage\": 1000\n" +
                "    },\n" +
                "    \"Market\": {\n" +
                "      \"DefaultMarket\": \"Amazon\",\n" +
                "      \"MinimumUpdateInterval\": 0,\n" +
                "      \"Markets\": {\n" +
                "        \"Mariana-0001\": {\n" +
                "          \"AppPackage\": \"com.android.vending\",\n" +
                "          \"AppUrl\": \"market://details?id=\",\n" +
                "          \"WebUrl\": \"https://play.google.com/store/apps/details?id=\"\n" +
                "        },\n" +
                "        \"Google\": {\n" +
                "          \"AppPackage\": \"com.android.vending\",\n" +
                "          \"AppUrl\": \"market://details?id=\",\n" +
                "          \"WebUrl\": \"https://play.google.com/store/apps/details?id=\"\n" +
                "        },\n" +
                "        \"Amazon\": {\n" +
                "          \"AppPackage\": \"com.amazon.venezia\",\n" +
                "          \"AppUrl\": \"amzn://apps/android?p=\",\n" +
                "          \"WebUrl\": \"http://www.amazon.com/gp/mas/dl/android?p=\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"Connection\": {\n" +
                "      \"SigKey\": \"1\",\n" +
                "      \"HashKey\": \"x5UJ~fb}3_Dma>l B]YB/?'1As[\\\"E<I!\",\n" +
                "      \"EncryptionKey\": \"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\",\n" +
                "      \"EncryptionKeyVersion\": \"2\"\n" +
                "    },\n" +
                "    \"LocationManager\": {\n" +
                "      \"LastKnownLocationExpireTime\": 3600,\n" +
                "      \"IPLocationServerURL\": \"https://service.appcloudbox.net/ip2location/mylocation/\",\n" +
                "      \"IPLocationKey\": \"79p2sm0slc2dy4qm\"\n" +
                "    },\n" +
                "    \"IPLocaleManager\": {\n" +
                "      \"IPLocaleServerURL\": \"https://location.appcloudbox.net/prod/country\",\n" +
                "      \"IPLocaleKey\": \"0}Z|[t=2!,C2BM9>p#Wjot,Ra[)U>*&-\"\n" +
                "    },\n" +
                "    \"DiverseSession\": null,\n" +
                "    \"KeepCenter\": {\n" +
                "      \"Enabled\": true,\n" +
                "      \"WebSocketURL\": \"ws://54.86.40.163:8014\",\n" +
                "      \"MessageTimeout\": 60,\n" +
                "      \"PingInterval\": 240,\n" +
                "      \"ConnectTimeIntervalWhenNetworkAvailable\": 3,\n" +
                "      \"MaxRetryCountOnConnectionFailure\": 10,\n" +
                "      \"InitialRetryTimeIntervalOnConnectionFailure\": 10\n" +
                "    }\n" +
                "  },\n" +
                "  \"libFramework\": {\n" +
                "    \"Push\": {\n" +
                "      \"SenderID\": \"732901537972\",\n" +
                "      \"SendTokenToServer\": true\n" +
                "    },\n" +
                "    \"Alerts\": {\n" +
                "      \"LocalFile\": \"alerts_test_2.plist\",\n" +
                "      \"RemoteUrl\": \"http://ihandysoftdevelop.s3.amazonaws.com/alerts/alerts_test_1.plist\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"libRtot\": {\n" +
                "    \"RequestPercentage\": 950,\n" +
                "    \"Tasks\": [\n" +
                "      \"TestAlert\",\n" +
                "      \"TestAlert1\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        String password = "sjdjjfjkdsf0slld.x;;dasjewids9i3slfdsjfas";

        System.out.println("加密前"+content);

        // 加密
        String s =  SecurityUtils.encrypt(content, password);
        System.out.println("加密后的内容：" + s);

        // 解密


        String des = SecurityUtils.decrypt(s,password);
        System.out.println("解密后的内容：" + des);

    }
}


