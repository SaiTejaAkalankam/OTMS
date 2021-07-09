import { Component , OnInit } from '@angular/core';
import { InsertService } from './insert-service';
import { Question } from './question';
import {Router} from '@angular/router';
@Component({
    selector: 'add-question',
    templateUrl: './insert-component.html'
})
export class InsertComponent implements OnInit
{
   question:Question=new Question(0,0,'','','','',0,0.0);
   public constructor(private insertService:InsertService, private router :Router){}
   public insertQuestion() : void
   {
      this.insertService.insertQuestion(this.question).subscribe();
      var a = confirm("New question details are successfully added! You can check the details and re-direct to this page by clicking 'OK' or click 'Cancel' to go back to home!");
      if(a==true)
      {
        this.router.navigate(['/QuestionList']);
      } 
      else
      {
       this.router.navigate(['/AdminHome']);
      }
   }
   ngOnInit()
   {
   }

}