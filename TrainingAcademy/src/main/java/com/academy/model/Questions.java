package com.academy.model;

public class Questions {

		public String course;
	    public String question;
	    public String optionA;
	    public String optionB;
	    public String optionC;
	    public String optionD;
	    public String correctAnswer;
	    public String id;
	    

	    


		public Questions(String course, String question, String optionA, String optionB, String optionC,
				String optionD, String correctAnswer, String id) {
			super();
			this.course = course;
			this.question = question;
			this.optionA = optionA;
			this.optionB = optionB;
			this.optionC = optionC;
			this.optionD = optionD;
			this.correctAnswer = correctAnswer;
			this.id = id;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getCourse() {
			return course;
		}


		public void setCourse(String course) {
			this.course = course;
		}


		public String getQuestion() {
			return question;
		}


		public void setQuestion(String question) {
			this.question = question;
		}


		public String getOptionA() {
			return optionA;
		}


		public void setOptionA(String optionA) {
			this.optionA = optionA;
		}


		public String getOptionB() {
			return optionB;
		}


		public void setOptionB(String optionB) {
			this.optionB = optionB;
		}


		public String getOptionC() {
			return optionC;
		}


		public void setOptionC(String optionC) {
			this.optionC = optionC;
		}


		public String getOptionD() {
			return optionD;
		}


		public void setOptionD(String optionD) {
			this.optionD = optionD;
		}


		public String getCorrectAnswer() {
			return correctAnswer;
		}


		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}

		


		public Questions() {
			// TODO Auto-generated constructor stub
		}


		
	}


