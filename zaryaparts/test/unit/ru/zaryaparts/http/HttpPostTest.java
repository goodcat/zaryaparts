package ru.zaryaparts.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpPostTest {
	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://exist.ru/price.aspx?pcode=961+753+43");
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
			nameValuePairs.add(new BasicNameValuePair("__EVENTTARGET", "ctl00$ctl00$b$b$ddlPriceLevel"));
			nameValuePairs.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWFgLb3Y/WCALHitagDQLX5fzOAQLI5fzOAQLJ5fzOAQLK5fzOAQLL5fzOAQLM5fzOAQLN5fzOAQLO5fzOAQKIoeKeBQK68ojtCwLhnd6dBwLRndadBwLUnd6dBwLHw4SyDQLHw4CyDQLHw4yyDQLHw5CyDQLHw5SyDQLHw5yyDQKBnpDPDQ=="));
			nameValuePairs.add(new BasicNameValuePair("__LASTFOCUS", ""));
			nameValuePairs.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwULLTE2MjcxNTIyMDkPFgQeAnNkCyonU3lzdGVtLldlYi5VSS5XZWJDb250cm9scy5Tb3J0RGlyZWN0aW9uAB4FU3JjSWQB/P8WAmYPZBYCZg9kFgYCBg9kFgICBg8WAh4HVmlzaWJsZWhkAgoPZBYCAgEPPCsABQEADxYCHg9TaXRlTWFwUHJvdmlkZXIFF0V4dGVuZGVkU2l0ZU1hcFByb3ZpZGVyZGQCDg9kFgICAg9kFgJmD2QWAmYPZBYEZg9kFgICAw88KwARAQEQFgAWABYAZAIBD2QWCgIBD2QWAmYPZBYCAgEPFgIeBFRleHQFFNCc0L7RgdC60LLQsCDQuCDQnNCeZAIHDxAPFgQeC18hRGF0YUJvdW5kZx8CZ2QQFQgO0KDQvtC30L3QuNGG0LAQ0JjQvdGC0LXRgNC90LXRggNWSVAI0J7Qv9GCIDEI0J7Qv9GCIDII0J7Qv9GCIDMI0J7Qv9GCIDQI0J7Qv9GCIDUVCAEwATEBMgEzATQBNQE2ATcUKwMIZ2dnZ2dnZ2cWAQIBZAILDxAPFgQeB0NoZWNrZWRnHgdFbmFibGVkaGRkZGQCEQ9kFgICAQ8QZA8WA2YCAQICFgMQBQPigqwFAkVVZxAFASQFAlVTZxAFB9Cg0YPQsS4FAlJVZxYBAgJkAhgPZBYCAgEPFgIfBAXdATxhIGhyZWY9Ii9Qcm9maWxlL0hpbnQvU2VuZEVycm9yLmFzcHg/cGlkPUYyMDA2NUYyIiBvbmNsaWNrPSJTaG93VGlwTGF5ZXIodGhpcywgZXZlbnQsIHRoaXMuaHJlZiwgNTUwLCA0NTApO3JldHVybiBmYWxzZTsiIHRhcmdldD0iX2JsYW5rIiBjbGFzcz0ibGlua1B0ciIgc3R5bGU9ImJvcmRlci1ib3R0b206MXB4IGRvdHRlZCBibGFjayI+0KHQvtC+0LHRidC40YLQtSDQvdCw0Lw8L2E+ZBgHBR1jdGwwMCRjdGwwMCRtb2JpbGVNZW51JG12VXNlcg8PZAIBZAUbY3RsMDAkY3RsMDAkY3VzdExvZ2luJGN0bDA0Dw9kAgJkBRZjdGwwMCRjdGwwMCRiJGIkbXZNYWluDw9kAgFkBRVjdGwwMCRjdGwwMCRiJGIkY3RsMTAPZ2QFHGN0bDAwJGN0bDAwJGIkYiRtdlJlZ2lvblRleHQPD2RmZAUjY3RsMDAkY3RsMDAkYm90dG9tJHVjQ291bnRlcnMkY3RsMDMPD2RmZAUVY3RsMDAkY3RsMDAkYiRiJGN0bDA5DzwrAAwBCAIBZA=="));
			nameValuePairs.add(new BasicNameValuePair("	ctl00$ctl00$b$b$ddlPriceLevel", "3"));
			nameValuePairs.add(new BasicNameValuePair("	ctl00$ctl00$b$b$hdnPid", "F20065F2"));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
