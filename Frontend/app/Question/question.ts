export class Question
{
  testId:number;
  questionId:number;
  questionContent:string;
  option1:string;
  option2:string;
  option3:string;
  marks:number;
  answerOption:number;
  public constructor(testId:number, questionId:number,questionContent:string,option1:string,option2:string,option3:string,marks:number,answerOption:number)
  {
   this.testId =testId;
   this.questionId=questionId;
   this.questionContent=questionContent;
   this.option1=option1;
   this.option2=option2;
   this.option3=option3;
   this.marks=marks;
   this.answerOption=answerOption;
  }
}