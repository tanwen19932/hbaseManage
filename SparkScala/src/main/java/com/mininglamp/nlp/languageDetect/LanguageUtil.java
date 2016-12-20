package com.mininglamp.nlp.languageDetect;

import com.mininglamp.nlp.languageDetect.impl.LangRecog;

import java.io.IOException;

/**
 * Created by mxf on 16/11/2.
 */
public class LanguageUtil {
	private LanguageDetect langDetact = new LanguageDetect();
	private LanguageMap nameMap = new LanguageMap();
	public static LanguageUtil instance = null;
	private static synchronized void init(){
		if(instance == null){
			instance = new LanguageUtil();
		}
	}
	public static LanguageUtil getInstance() {
		if( instance == null){
			init();
		}
		return instance;
	}

	public String detect(String text) {
		String lang = evalCJK(text);
		if (lang.length() == 0)
			lang = langDetact.langDetect(text);
		return lang;
	}

	private String evalCJK(String text) {
		String lang = LangRecog.getInstance().detect(text);
		return lang;
	}

	public String getChineseName(String enName) {
		return nameMap.getZhName(enName);
	}

	public static void main(String[] args) throws IOException {
		LanguageDetect langUtil = new LanguageDetect();
		String a = "美国摄影师记录民国上海街头百态_网易新闻 2016-11-14 11:18 图集已浏览完毕 推荐内容 索姆河战役百年:一战最大＂人间… 明仁登基:鱼类学家的天皇之路 苏联＂梦想家＂托洛茨基输在太天… 红色白求恩:宣传画里的国际主义… 阿拉法特离世十二载:中东不死鸟… 照相馆摄影师詹布鲁恩镜头下的民… 破碎的水晶之夜:犹太街区劫后一… 选举是一场戏！媒体时代的美国选战 清末版画看甲午:朝鲜大捷痛击小… 神秘东方:近代欧洲人眼里多彩世界 十月革命99年:封存在漫画里的歌… 3D成像:美国南北战争立体影像集 推荐视频 春晚一审:笑抽了！ 女主持王婧涉毒被拘 上 一 图 片 下 一 图 集 明仁登基:鱼类学家的天皇之路 { \"info\": { \"setname\": \"美国摄影师记录民国上海街头百态\", \"imgsum\": 30, \"lmodify\": \"2016-11-14 11:19:49\", \"prevue\": \"\", \"channelid\": \"0001\", \"reporter\": \"\", \"source\": \"网易";
		String b = "野菜の価格高騰を理由に三重県鈴鹿市の教育委員会が来月と再来月の２日間、小学校などの給食を中止するとしたことについて、鈴鹿市は７日、「批判が多い」などとして中止の方針を撤回することを明らかにしました。";
		String c = "80年代的美国“春假”:青年人怎么玩？_网易新闻##br####br##2016-11-20 09:35##br####br##图集已浏览完毕##br####br##推荐内容##br####br##二战前流浪在欧洲各国的吉普赛人##br####br##＂999朵玫瑰＂:20世纪初中国最早…##br####br##孙立人离世26载:将军百战身名裂?##br####br##一战罕见彩照:中国劳工战地小憩##br####br##【慎入】捷克人骨教堂:骷髅拼成…##br####br##罪名千奇百怪:1870年代英国监狱…##br####br##十字军东征:宗教圣战还是寻宝之路?##br####br##暴徒的情妇们:纽约＂黑手党＂背…##br####br##被苏军打的找不着北:日本陆军史…##br####br##前苏联的＂飞天猪＂是如何诞生的?##br####br##沉入太平洋海底的二战飞机残骸##br####br##日本投降9年后:民众见到陆自坦克…##br####br##推荐视频##br####br##春晚一审:笑抽了！##br####br##女主持王婧涉毒被拘##br####br##上##br####br##一##br####br##图##br####br##片##br####br##下##br####br##一##br####br##图##br####br##集##br####br##二战前流浪在欧洲各国的吉普赛人##br####br##{##br####br##\"info\": {##br####br##\"setname\": \"80年代的美国“春假”:青年人怎么玩？\",##br####br##\"imgsum\": 11,##br####br##\"lmodify\": \"2016-11-20 09:36:38\",##br####br##\"prevue\": \"\",##br####br##\"channelid\": \"0001\",##br####br##\"reporter\": \"\",##br####br##\"source\": \"网易历史\",##br####br##\"dutyeditor\": \"钱珏晓_BJS2543\",##br####br##\"prev\": {##br####br##\"setname\": \"\\\"999朵玫瑰\\\":20世纪初中国最早的女大学生\",##br####br##\"simg\": \"http://img6.cache.netease.com/photo/0001/2016-11-19/100x75_C67PGHE86R2E0001.jpg\",##br####br##\"seturl\": \"http://news.163.com/photoview/6R2E0001/2213565.html\"##br####br##},##br####br##\"next\": {##br####br##\"setname\": \"二战前流浪在欧洲各国的吉普赛人\",##br####br##\"simg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/100x75_C6AABSCU6R2E0001.jpg\",##br####br##\"seturl\": \"http://news.163.com/photoview/6R2E0001/2213728.html\"##br####br##}##br####br##},##br####br##\"list\": [##br####br##{##br####br##\"id\": \"C6AA95F36R2E0001\",##br####br##\"img\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA95F36R2E0001.jpg\",##br####br##\"timg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/t_C6AA95F36R2E0001.jpg\",##br####br##\"simg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA95F36R2E0001.jpg\",##br####br##\"oimg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/C6AA95F36R2E0001.jpg\",##br####br##\"osize\": {\"w\":758,\"h\":595},##br####br##\"title\": \"\",##br####br##\"note\": \"每年的三四月份，美国各学校都会放大约十天的春假，于是大批少男少女涌向温暖的南方沙滩尽情狂欢。\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA98286R2E0001\",##br####br##\"img\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA98286R2E0001.jpg\",##br####br##\"timg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/t_C6AA98286R2E0001.jpg\",##br####br##\"simg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA98286R2E0001.jpg\",##br####br##\"oimg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/C6AA98286R2E0001.jpg\",##br####br##\"osize\": {\"w\":798,\"h\":525},##br####br##\"title\": \"\",##br####br##\"note\": \"后来春假也逐渐演变成了美国的传统，不仅是学生，美国家庭也会在这段时间找一些温暖舒适的地方度假。\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9BGH6R2E0001\",##br####br##\"img\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9BGH6R2E0001.jpg\",##br####br##\"timg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/t_C6AA9BGH6R2E0001.jpg\",##br####br##\"simg\": \"http://img5.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9BGH6R2E0001.jpg\",##br####br##\"oimg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/C6AA9BGH6R2E0001.jpg\",##br####br##\"osize\": {\"w\":798,\"h\":524},##br####br##\"title\": \"\",##br####br##\"note\": \"这组照片拍摄于1980年代的佛罗里达的戴托纳海滩，青年男女们穿着泳装在沙滩上尽情狂欢，挥洒青春。\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9E2M6R2E0001\",##br####br##\"img\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9E2M6R2E0001.jpg\",##br####br##\"timg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/t_C6AA9E2M6R2E0001.jpg\",##br####br##\"simg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9E2M6R2E0001.jpg\",##br####br##\"oimg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/C6AA9E2M6R2E0001.jpg\",##br####br##\"osize\": {\"w\":801,\"h\":522},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9LT06R2E0001\",##br####br##\"img\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9LT06R2E0001.jpg\",##br####br##\"timg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/t_C6AA9LT06R2E0001.jpg\",##br####br##\"simg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9LT06R2E0001.jpg\",##br####br##\"oimg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/C6AA9LT06R2E0001.jpg\",##br####br##\"osize\": {\"w\":799,\"h\":535},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9N8C6R2E0001\",##br####br##\"img\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9N8C6R2E0001.jpg\",##br####br##\"timg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/t_C6AA9N8C6R2E0001.jpg\",##br####br##\"simg\": \"http://img5.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9N8C6R2E0001.jpg\",##br####br##\"oimg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/C6AA9N8C6R2E0001.jpg\",##br####br##\"osize\": {\"w\":798,\"h\":531},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9OIN6R2E0001\",##br####br##\"img\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9OIN6R2E0001.jpg\",##br####br##\"timg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/t_C6AA9OIN6R2E0001.jpg\",##br####br##\"simg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9OIN6R2E0001.jpg\",##br####br##\"oimg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/C6AA9OIN6R2E0001.jpg\",##br####br##\"osize\": {\"w\":800,\"h\":537},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9QA66R2E0001\",##br####br##\"img\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9QA66R2E0001.jpg\",##br####br##\"timg\": \"http://img5.cache.netease.com/photo/0001/2016-11-20/t_C6AA9QA66R2E0001.jpg\",##br####br##\"simg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9QA66R2E0001.jpg\",##br####br##\"oimg\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/C6AA9QA66R2E0001.jpg\",##br####br##\"osize\": {\"w\":800,\"h\":525},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9RUR6R2E0001\",##br####br##\"img\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9RUR6R2E0001.jpg\",##br####br##\"timg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/t_C6AA9RUR6R2E0001.jpg\",##br####br##\"simg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9RUR6R2E0001.jpg\",##br####br##\"oimg\": \"http://img5.cache.netease.com/photo/0001/2016-11-20/C6AA9RUR6R2E0001.jpg\",##br####br##\"osize\": {\"w\":800,\"h\":503},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9TRI6R2E0001\",##br####br##\"img\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9TRI6R2E0001.jpg\",##br####br##\"timg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/t_C6AA9TRI6R2E0001.jpg\",##br####br##\"simg\": \"http://img3.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9TRI6R2E0001.jpg\",##br####br##\"oimg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/C6AA9TRI6R2E0001.jpg\",##br####br##\"osize\": {\"w\":799,\"h\":529},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##},##br####br##{##br####br##\"id\": \"C6AA9VFQ6R2E0001\",##br####br##\"img\": \"http://img2.cache.netease.com/photo/0001/2016-11-20/900x600_C6AA9VFQ6R2E0001.jpg\",##br####br##\"timg\": \"http://img5.cache.netease.com/photo/0001/2016-11-20/t_C6AA9VFQ6R2E0001.jpg\",##br####br##\"simg\": \"http://img4.cache.netease.com/photo/0001/2016-11-20/100x75_C6AA9VFQ6R2E0001.jpg\",##br####br##\"oimg\": \"http://img6.cache.netease.com/photo/0001/2016-11-20/C6AA9VFQ6R2E0001.jpg\",##br####br##\"osize\": {\"w\":798,\"h\":520},##br####br##\"title\": \"\",##br####br##\"note\": \"\",##br####br##\"newsurl\": \"#\"##br####br##}##br####br##]##br##}##br####br##图集热榜##br####br##";
		System.out.println(langUtil.langDetect(a));

	}
}