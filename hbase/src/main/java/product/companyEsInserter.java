package product;

import es.client.ESClient;
import hbase.hbaseUniversalDao.UniversalDao;
import net.sf.json.JSONObject;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

import java.io.IOException;
import java.net.UnknownHostException;

public class companyEsInserter {
	static final ThreadLocal<Client> client = new ThreadLocal<Client>() {
		@Override
		protected Client initialValue() {
			try {
				return ESClient.getClient("es", "192.168.55.10", 9200);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	public static void insertCompany(Company company)
			throws InterruptedException, UnknownHostException {
		JSONObject jsonQuery=new JSONObject();
		String id  = String.valueOf(company.getCompanyId());
		jsonQuery.put("id", id);
		jsonQuery.put("companyName", company.getCompanyName());
		jsonQuery.put("companyAlias", company.getCompanyAlias());
		jsonQuery.put("industryName", company.getIndustryName());
		jsonQuery.put("companyIntro", company.getCompanyIntro());
		jsonQuery.put("companyLogo", company.getCompanyLogo());


		IndexRequestBuilder indexRequestBuilder = client.get().prepareIndex("product", "company", id);
		indexRequestBuilder.setSource(jsonQuery.toString());
		Thread.sleep(500);
	}
	private static UniversalDao myDao = null;
	static {
		myDao = new UniversalDao("Company", "C" , new Company()){
			@Override
			public void handleAll(Object obj) {
				// TODO Auto-generated method stub
				Company company = (Company ) obj;
				try {
					insertCompany(company);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}

	public static void main(String[] args) throws IOException {
		myDao.getAll();
	}
}
