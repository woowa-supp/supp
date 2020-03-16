package com.woowa.supp.crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawler {

	public static void main(String[] args) {
		String userGitHubName = "toneyparky";

		String url = "https://github.com/woowacourse/java-lotto/commits/" + userGitHubName; //크롤링할 url지정
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Elements element = doc.select("div.commit-desc");

		System.out.println("============================================================");

		System.out.println(element.select("pre.text-small"));

		System.out.println("============================================================");
	}
}