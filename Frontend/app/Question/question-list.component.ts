import { Component , OnInit} from '@angular/core';
import { QuestionService } from './question-service';
import { Question } from './question';
@Component({
   selector: 'question-list',  
   templateUrl: './question-list.component.html'
})
export class QuestionListComponent implements OnInit
{
   testId : number; 
    questions:Question[];
    public constructor(private questionService:QuestionService){}

    
    public getQuestions(testId: number):void
    {
      this.testId = testId;
       this.questionService.getQuestions(testId).subscribe(data => this.questions=data);
       console.log(this.testId)
    }
    public getAllQuestions():void
    {
       this.questionService.getAllQuestions().subscribe(data => this.questions=data);
    }
    ngOnInit(){}
}