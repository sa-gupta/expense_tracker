package com.sach.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sach.expense.model.Expense;
import com.sach.expense.repository.ExpenseRepo;

@Service
public class ExpenseService {

	private final ExpenseRepo expenseRepository;

	public ExpenseService(ExpenseRepo expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	}

	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("Cannot find expense by ID %s", expense.getId())));
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseRepository.save(expense);
	}

	public List<Expense> getAllExpense() {
		return expenseRepository.findAll();
	}

	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
						String.format("Cannot find expense by name %s", name)));
	}

	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
