package com.g25.mailer.user.filter;

//public class UserAuthenticationFilter extends OncePerRequestFilter {

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//
//        if (!isNull(user)) {
//            GrantedAuthority authority = new SimpleGrantedAuthority("USER"); // 사용자 권한
//            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(authority)); // 현재 사용자의 인증 정보
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        } else {
//            filterChain.doFilter(request, response);
//        }
//
//    }

//}