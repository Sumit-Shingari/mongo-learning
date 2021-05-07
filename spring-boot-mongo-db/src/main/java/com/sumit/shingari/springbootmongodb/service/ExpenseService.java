package com.sumit.shingari.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sumit.shingari.springbootmongodb.model.Expense;
import com.sumit.shingari.springbootmongodb.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
    public void addExpense(Expense expense) {
    	expenseRepository.insert(expense);
    }
	
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId())
							   .orElseThrow(() -> new RuntimeException(
									   String.format("Cannot find expense by id %s", expense.getId())));
		
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseRepository.save(savedExpense);
	}
	
	public List<Expense> getAllExpense() {
		return expenseRepository.findAll();
	}
	
	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
				   String.format("Cannot find expense by id %s", name)));
	}
	
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
