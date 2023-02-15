package com.bit.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class EmpDao {
	com.mongodb.client.MongoClient client;
	String DBNAME = "lecture";
	String COLNAME = "emp";
	String URL = "mongodb://root:mongo@localhost:27018/";
	
	public void updateOne(EmpDto bean) {
		client = MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> col = db.getCollection(COLNAME);
		
		Bson filter = Filters.eq("_id", bean.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("ename", bean.getEname());
		map.put("sal", bean.getSal());
		map.put("hiredate", bean.getHiredate());
		map.put("job", bean.getJob());

//		Bson update = new Document(map);
		List<Bson> list = Arrays.asList(
					Updates.set("ename", bean.getEname()),
					Updates.set("sal", bean.getSal()),
					Updates.set("job", bean.getJob()),
					Updates.set("hiredate", bean.getHiredate())
		);
		
		col.updateOne(filter, list);
		client.close();
	}
	
	public EmpDto selectOne(ObjectId _id) {
		EmpDto bean = new EmpDto();
		
		client = MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> col = db.getCollection(COLNAME);
		
		Bson filter = Filters.eq("_id", _id);
//		Bson filter = Filters.lt("_id", _id);
//		Bson filter = Filters.gt("_id", _id);
		
		FindIterable<Document> ite = col.find(filter);
		Document doc = ite.first();
		
		bean.setId(doc.getObjectId("_id"));
		bean.setEmpno(doc.getInteger("empno"));
		bean.setEname(doc.getString("ename"));
		bean.setHiredate(doc.getDate("hiredate"));
		bean.setJob(doc.getString("job"));
		bean.setSal(doc.getInteger("sal"));
		
		client.close();
		
		return bean;
	}
	
	public void insertOne(EmpDto bean) {
//		com.mongodb.client.MongoClient client;
		client = MongoClients.create(URL);
		MongoDatabase dbs = client.getDatabase(DBNAME);
		dbs.getCollection("emp");
		MongoCollection<Document> col = dbs.getCollection(COLNAME);
		
		Document doc = new Document();
		
		doc.append("empno", bean.getEmpno());
		doc.append("ename", bean.getEname());
		doc.append("hiredate", bean.getHiredate());
		doc.append("sal", bean.getSal());
		doc.append("job", bean.getJob());
		
		col.insertOne(doc);
		
		client.close();
	}
	
	public List<EmpDto> selectAll() {
		List<EmpDto> list=new ArrayList<>();
		int port = 27018;
		
//		MongoClient client = new MongoClient(new ServerAddress(URL,port));
		client = MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> docs = db.getCollection(COLNAME);
		FindIterable<Document> rs = docs.find();
		
		MongoCursor<Document> ite = rs.iterator();
		while(ite.hasNext()) {
			Document doc = ite.next();
			EmpDto bean = new EmpDto();
			
			bean.setId(doc.getObjectId("_id"));
			bean.setEmpno(doc.getInteger("empno"));
			bean.setEname(doc.getString("ename"));
			bean.setHiredate(doc.getDate("hiredate"));
			bean.setSal(doc.getInteger("sal"));
			bean.setJob(doc.getString("job"));
			
			list.add(bean);
		}
		
		client.close();
		return list;
	}
	
	
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		dao.selectAll();
	}
	
}
