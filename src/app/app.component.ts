import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RestService, Student } from './rest.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  ngOnInit(): void {
   this.getAllStudent();
  }
  title = 'Basic_rest_api';
  constructor(private restService:RestService){

  }
  newStudent: Student =new Student(0,"","");
  addStudent(): void {
    this.restService.addStudent(this.newStudent).subscribe(
      (addedStudent) => {
        console.log('Student added successfully:', addedStudent);
        this.getAllStudent();
        //this.newStudent = { id: 0, name: '', city: '' };
      },
      (error) => {
        console.error('Error adding student:', error);
      }
    );
  }
  students:Student[]=[];
  getAllStudent(){
    this.restService.getAllStudent().subscribe(data=>this.students=data);
  }
  deleteStudent(id: number): void {
    this.restService.deleteById(id).subscribe(
      () => {
        // Successfully deleted, you might want to refresh the list or do other actions.
        console.log('Student deleted successfully.');
        this.getAllStudent();
      },
      (error) => {
        console.error('Error deleting student:', error);
      }
    );
  }

  
}

