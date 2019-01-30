import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationsService {
  
  private baseUrl = 'http://localhost:9000/api/location';
 
  constructor(private http: HttpClient) { }
 
  getLocation(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createLocation(location: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, location);
  }
 
  updateLocation(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteLocation(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 
  getLocationList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
 
  getLocationById(age: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/age/${age}`);
  }
 
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}
