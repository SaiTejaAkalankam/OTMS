import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';
import { Injectable } from '@angular/core';
@Injectable({
   providedIn:'root'
})
export class QuestionService
{
   public constructor(private httpClient:HttpClient){ }
   
   public getQuestion(questionId:number)  : Observable<Question>
   {
      return this.httpClient.get<any>('http://localhost:8092/getQuestion/'+questionId);
   }
   public getQuestions(testId: number) : Observable<Question[]>
   {
      return this.httpClient.get<Question[]>('http://localhost:8092/getQuestions/'+testId);
   }
   public deleteQuestion(testId:number,questionId:number) : any
   {
       return this.httpClient.delete<any>('http://localhost:8092/deleteQuestion/'+testId+'/'+questionId);
   }
   public getAllQuestions() : Observable<Question[]>
   {
      return this.httpClient.get<Question[]>('http://localhost:8092/getQuestions/');
   }

} 