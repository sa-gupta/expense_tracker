package com.sach.expense.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sach.expense.model.Expense;

public interface ExpenseRepo extends MongoRepository<Expense, String> {
	@Query("{'name': ?0}")
	Optional<Expense> findByName(String name);
}
