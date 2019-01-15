import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private baseUrl = 'http://localhost:9000/api/';	
  title = 'Product Reviews';
}
