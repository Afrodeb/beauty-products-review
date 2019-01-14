import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
 
import { UserService } from '../services/user.service';
import { User } from '../services/user';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
	user: User=new User;
  users: Array<object> = [];
  submitted = false;
  constructor(private userService: UserService) { }
 
 

  ngOnInit() {
	  this.reloadData();
  }
deleteUsers() {
    this.userService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }
 
  reloadData() {
	this.userService.getUserList().subscribe((data: Array<object>) => {
this.users = data;
console.log(data);
});
  }
}
