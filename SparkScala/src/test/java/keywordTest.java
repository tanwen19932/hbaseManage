
import edu.buaa.nlp.text.inter.IKeyExtracter;
import edu.buaa.nlp.text.process.factory.TextProcessFactory;
import edu.buaa.nlp.text.process.keyword.KeyExtractor;

public class keywordTest {
	
	public static void main(String[] args) {
		IKeyExtracter keyExtracter = new KeyExtractor();;

		TextProcessFactory.getKeyExtractor().KeyExtractForString("初始化 是 很 必要 的", "cn", 5);
		String[] keywords;
	    String text = "　今日，胡润研究院发布《2016胡润女富豪榜》，北京地产女王、75岁的陈丽华以505亿财富首次成为中国女首富。\n" +
                "\n" +
                "新闻一出，评论里也立刻炸了：\n" +
                "\n" +
                "而帮主(id：banlicai)则想说\n" +
                "\n" +
                "　　——厉害了，word师父!——\n" +
                "\n" +
                "　　女首富的丈夫是《西游记》中“唐僧”\n" +
                "\n" +
                "　　 迟重瑞\n" +
                "\n" +
                "在京投房地产面积超过150万平米\n" +
                "\n" +
                "　　 产业集聚王府井\n" +
                "\n" +
                "　　福布斯女富豪榜显示，从事房地产行业人数最多，达到23%;而前十位女富豪中，有七位从事房地产行业。\n" +
                "\n" +
                "　　陈丽华同样靠房地产登顶福布斯女富豪榜。\n" +
                "\n" +
                "　　据陈丽华身下的富华国际集团(下称“富华”)官网介绍，富华1988年在香港成立，是一家多元化实业投资企业，支柱产业涵盖房地产、资产运营管理、文化艺术、金融等领域。\n" +
                "\n" +
                "　　富华集团官网显示，富华集团项目遍及北京、天津、安徽、珠海、三亚、墨尔本等地。其中，富华在北京已建成使用和在建的经营性地产投资项目面积超过150万平米。\n" +
                "\n" +
                "　　在北京，长安俱乐部、中国紫檀博物馆、北京丽苑公寓、金宝街、中国紫檀万豪行政公寓、长安太和、长安运河、紫檀大厦等均为北京地区地标性建筑。\n" +
                "\n" +
                "中国紫檀博物馆\n" +
                "\n" +
                "　　尤其值得注意的是，富华集团独立开发及运营的金宝街位居北京核心地段王府井商业区。在730米的金宝街上，汇聚了金宝大厦、华丽大厦、丽晶酒店，丽亭酒店、励骏酒店、金宝汇购物中心和北京香港马会会所等高端商业地产项目。\n" +
                "\n" +
                "北京金宝街\n" +
                "\n" +
                "　　此外，金宝街上也汇聚了宝缇嘉、克莱利亚尼、古驰、奥罗芙珠宝、巴宝莉、欧米茄等奢侈品，成为北京地区著名的奢侈品集聚区。\n" +
                "\n" +
                "金宝街上的奢侈品旗舰店\n" +
                "\n" +
                "　　“以高端地产为发展核心，自主开辟出一条‘高端地产全产业平台’的道路”，富华集团官网概括了陈丽华的商业版图发展之路。\n" +
                "\n" +
                "　　帮主(id：banlicai)梳理，陈丽华的地产项目不少围绕着王府井及其周边展开。其中，长安大厦临近紫禁城、天安门广场，丽苑公寓、丽山大厦、富华园小区等均位于王府井周边。\n" +
                "\n" +
                "　　 家境贫寒\n" +
                "\n" +
                "　　 第一桶金来源说法不一\n" +
                "\n" +
                "　　但陈丽华并非生于富贵之家。\n" +
                "\n" +
                "　　1941年生于北京，满族，因家境贫寒，读到高中时辍学。但陈丽华很有生意头脑，为人豪爽，1977年，陈丽华有了自己的家具厂后陈丽华于80年代移居香港。\n" +
                "\n" +
                "　　但家具厂明显不可能是陈丽华的庞大商业版图的第一桶金，至今关于陈丽华第一桶金的来源有多种说法。\n" +
                "\n" +
                "有传言称，陈丽华的第一桶金来源于这里：\n" +
                "\n" +
                "　　据媒体报道，有“熟悉”陈丽华的人称，80年代中期，陈丽华了解到北京龙顺城中式家具厂有大量文革时的珍贵明清紫檀、金丝楠、黄花梨木家具，而这些名贵家具却“无主”。\n" +
                "\n" +
                "　　陈丽华以低价购得其中一部分，完成了原始的资本积累。也有说法，陈丽华移民香港后，在比华利入手12栋别墅后高价卖出，拿到了第一桶金。\n" +
                "\n" +
                "　　在香港没几年，陈丽华以港商身份回京。\n" +
                "\n" +
                "彼时，邓小平南方谈话在海内外引起极大反响，陈丽华带着香港淘来的真金白银回京。\n" +
                "\n" +
                "　　值得一提的是，陈丽华在回京当年，悄悄从香港战略转移，在澳大利亚、东南亚等地设立分公司进行地产投资。90年代，金融风暴席卷亚洲，陈丽华的商业版图却毫发无损。\n" +
                "\n" +
                "多面陈丽华：\n" +
                "\n" +
                "　　 红顶商人、慈善家、古迹杀手?\n" +
                "\n" +
                "　　在陈丽华成为女首富的热门评论中，有网友的评论概括了陈丽华的发家之路：\n" +
                "\n" +
                "　　“北京，西起金鱼胡同，东至建国门的金宝街，被她承包，京城著名的四大俱乐部之首--长安俱乐部在她的富华旗下，北京人，有点乡情和胡同情结从香港回来，反而成就了普普通通的她，那个时代好，中国需外资，有钱就可以站在国贸顶层，领导陪着欣赏京城所有壮观的建设塔吊，然后圈地。这样就成为了今天的她。”\n" +
                "\n" +
                "　　赶上内地改革的春风，陈丽华的商业版图不断扩张。但为何陈丽华能够拿到这些黄金地段?\n" +
                "\n" +
                "　　“人脉!”——有媒体给出了这样的答案。\n" +
                "\n" +
                "　　有消息称，长安大厦的工程让陈丽华意识到人脉的重要性。在项目落成后，陈丽华在长安大厦六楼成立长安俱乐部。\n" +
                "\n" +
                "　　据说，长安俱乐部的会员通常通过老会员的推荐才能入会，并且条件极为苛刻。最初招募会员的时候对年龄有所限制：必须要在45至55岁之间，是企业的“一把手”，公司资产至少在5000万以上，最好会说英语。自2003年来，由于年轻富豪的崛起，年龄限制被取消。\n" +
                "\n" +
                "俱乐部名商巨贾、知名人士来来往往，依靠强大的人脉资源，陈丽华的商业版图不断开疆辟土。\n" +
                "\n" +
                "　　除了人脉，眼界也成就了今日的陈丽华。\n" +
                "\n" +
                "　　金宝街改造采用投资商负责修路、改造周边旧房、解决居民拆迁费用等。不止现在，彼时拆迁也是开发商头疼的问题。但陈丽华用28天时间，完成了2100户居民的拆迁。后陈丽华将拆迁经验总结为“钱吃亏，人不能吃亏”，充分满足拆迁户的要求。\n" +
                "\n" +
                "　　在富华集团的官网上，董事长陈丽华被称为“爱国港商”，目前担任全国政协委员会港澳台侨委员会副主任、中国侨商投资企业协会常务副会长、北京侨商会会长等职务。\n" +
                "\n" +
                "　　富华集团也自称，富华也长期致力于扶贫赈灾、生态环保、公民教育、就业促进、艺术捐赠等公益事业，全面践行企业公民之责任，不断追求以更优异的表现回报社会。\n" +
                "\n" +
                "　　但红顶商人、慈善家之外，陈丽华也被称为“古迹杀手”。\n" +
                "\n" +
                "　　1998年，富华集团拿下北京市“金宝街市政改造及危改工程”的招商项目。\n" +
                "\n" +
                "　　该项目被称为“重要的市政工程”，为缓解王府井商业区紧张交通和提升城市建设水平的关键，将对东城区经济繁荣和大力支持北京申办奥运起到积极作用。但是这次的拆迁却在当地引发了很大争议，甚至招致了不少古城保护人士的强烈反对，而与之相关的法律诉讼也并不鲜见，而且有诉讼者表示，该公司通过“拆毁历史文物”收获了不小的财富。\n" +
                "\n" +
                "　　至今，围绕着这位女首富有多种猜测和声音，关于她和“唐僧”迟重瑞相差11岁的爱情、关于她的发家之路、关于她多面形象。\n" +
                "\n" +
                "　　但这并未影响到其财富上升之路。\n" +
                "\n" +
                "(新京报新媒体)\n" +
                "\n" +
                " 关于此事的后续：已于3月23日正式聘请律师处理相关侵权问题，至今还在进行当中，如有结果会第一时间上来更新，在此期间可前往当事人微博@PP不休了解最新进展。\n" +
                "\n" +
                "好吧……18天的四处投诉，仅仅要一句道歉还被倒打一耙……各位知乎大神们，小女子一事相求：帕金森在医学上能定义为残疾吗？百度上搜帕金森病人会出现精神上的问题，什么精神状态不适合乘坐飞机呢？凭借我当时观察的描述，是否为帕金森的典型症状呢？\n" +
                "\n" +
                "大家好，首先非常感谢各位知乎大神的出谋划策，看完后着实为自己的智商捉急。对于大家怀疑事件的真实性问题，抱歉我暂无法公布大家所提及的证据，在我不了解相关法律法规和没有征求当事人同意的情况下，请原谅我的小心谨慎。当初在知乎上发问题也是因为投诉无门，期望知乎大神们指点迷津。后来发生的事情完全出乎了我的意料，为了消除大家的疑惑，我就先放一张登机牌吧。";
    
		keywords=keyExtracter.KeyExtractForString(text, "zh", 4);
		for(String keyword: keywords)
			System.out.println(keyword + "  ");
	}
}
