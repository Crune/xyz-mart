package ganada.mc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ganada.action.common.SuperAction;

public class MCFooterAction implements SuperAction {

    @Override
    public String executeAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/jsp/mc/footer.jsp";
    }

}
