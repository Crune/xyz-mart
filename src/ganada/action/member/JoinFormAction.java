package ganada.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ganada.action.common.SuperAction;

public class JoinFormAction implements SuperAction {

    @Override
    public String executeAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        return "/jsp/member/inner_join.jsp";
    }

}
