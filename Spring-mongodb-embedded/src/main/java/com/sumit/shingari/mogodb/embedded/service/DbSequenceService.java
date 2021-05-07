package com.sumit.shingari.mogodb.embedded.service;


import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.sumit.shingari.mogodb.embedded.model.DbSequence;

@Service
public class DbSequenceService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public int getSequenceNumber(String sequenceName) {
		Query query = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seqNo", 1);
		DbSequence counter = mongoOperations
							.findAndModify(query, update, options().returnNew(true).upsert(true) , DbSequence.class);
		return !Objects.isNull(counter) ? counter.getSeqNo() : 1;
	}
	
}
