import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private httpClient:HttpClient) {

   }
   getAllStudent():Observable<Student[]>{
    return this.httpClient.get<Student[]>("http://localhost:8080/getAll");
   }
   deleteById(id:number):Observable<void>{
    return this.httpClient.delete<void>("http://localhost:8080/delete/"+id);
   }
   addStudent(student: Student): Observable<Student> {
    return this.httpClient.post<Student>("http://localhost:8080/save",student);
  }
}
export class Student{
  id:number;
  name:string;
  city:string;
  constructor(id:number,name:string,city:string){
    this.id=id;
    this.name=name;
    this.city=city;
  }

}
