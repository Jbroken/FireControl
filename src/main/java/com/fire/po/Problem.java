package com.fire.po;

public class Problem {
	
	private  String problem;

	private String count;

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return "Problem [problem=" + problem + ", count=" + count + "]";
	}

}
