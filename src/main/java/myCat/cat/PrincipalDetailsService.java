//package myCat.cat;
//
//import lombok.RequiredArgsConstructor;
//import myCat.cat.domain.User;
//import myCat.cat.repository.UserRepository2;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class PrincipalDetailsService implements UserDetailsService {
//
//    private final UserRepository2 userRepository2;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository2.findByLoginId(username)
//                .orElseThrow(() -> {
//                    return new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
//                });
//        return new PrincipalDetails(user);
//    }
//}
