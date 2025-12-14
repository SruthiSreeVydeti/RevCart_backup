import { HttpInterceptorFn } from '@angular/common/http';

export const simpleAuthInterceptor: HttpInterceptorFn = (req, next) => {
  // Skip auth endpoints
  if (req.url.includes('/auth/')) {
    return next(req);
  }

  // Get token from localStorage
  const token = localStorage.getItem('token');
  
  if (token) {
    const authReq = req.clone({
      setHeaders: {
        'Authorization': `Bearer ${token}`
      }
    });
    return next(authReq);
  }

  return next(req);
};