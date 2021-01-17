import { Component } from '@angular/core';
import { AuthenticationService } from '../app/login/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tourneyDaggerWeb';

  isLoggedIn = false;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    //this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    this.authenticationService.isLoggedInVar.subscribe(data=>{
      this.isLoggedIn=data;
    })
    console.log('menu ->' + this.isLoggedIn);
  }

  handleLogout() {
    this.authenticationService.logout();
    this.router.navigate(['/']);
  }


}
