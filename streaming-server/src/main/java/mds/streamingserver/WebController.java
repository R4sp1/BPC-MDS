package mds.streamingserver;


import mds.streamingserver.component.MyResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class WebController {

    private final static File MP4_FILE = new File("C:\\Users\\jirka\\Documents\\GitHub\\BPC-MDS\\Videos\\bbb_1080p.mp4");
    private MyResourceHttpRequestHandler handler;

    @Autowired
    public WebController(MyResourceHttpRequestHandler handler) {
        this.handler = handler;
    }

    @GetMapping("video")
    public String video() {
        return "videoMP4";
    }

    @GetMapping(path = "/file", produces = "video/mp4")
    @ResponseBody
    public FileSystemResource wholeFile() {
        return new FileSystemResource(MP4_FILE);
    }

    @GetMapping("byterange")
    public void byterange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);
    }



    @GetMapping()
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value="player", method={RequestMethod.POST})
    public String player(@RequestParam String url, @RequestParam String width, @RequestParam String autoplay, @RequestParam String muted, @RequestParam String poster, Model model){
        if(!StringUtils.isEmpty(url)) {
            model.addAttribute("url", url);
            model.addAttribute("width", width);
            model.addAttribute("autoplay", autoplay);
            model.addAttribute("muted", muted);
            model.addAttribute("poster", poster);
        }else{
            model.addAttribute("error", "URL not found");
        }
        return "player";
    }

    private final static String HLS_PATH = "C:\\Users\\jirka\\Documents\\GitHub\\BPC-MDS\\Videos\\HLS\\";
    private final static String DASH_PATH = "C:\\Users\\jirka\\Documents\\GitHub\\BPC-MDS\\Videos\\MPEG-DASH\\";

    @RequestMapping(value = {"/dash/{file}", "/hls/{file}", "/hls/{quality}/{file}"}, method = RequestMethod.GET)
    public void adaptive_streaming(@PathVariable("file") String file, @PathVariable(value = "quality", required = false) String quality, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File STREAM_FILE = null;

        String handle = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);

        switch (handle){
            case "/dash/{file}":
                STREAM_FILE = new File(DASH_PATH + file);
                break;
            case "/hls/{file}":
                STREAM_FILE = new File(HLS_PATH + file);
                break;
            case "/hls/{quality}/{file}":
                if (!StringUtils.isEmpty(quality)){
                    STREAM_FILE = new File(HLS_PATH + quality + "/" + file);
                }
                break;
            default:
                break;
        }

        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, STREAM_FILE);
        handler.handleRequest(request, response);
    }

    @RequestMapping(value = "dashPlayer", method = {RequestMethod.GET, RequestMethod.POST})
    public String dashPlayer(@RequestParam String url_dash, Model model) {
        model.addAttribute("url_dash", url_dash);
        return "dashPlayer";
    }

    @RequestMapping(value = "gallery", method = {RequestMethod.GET, RequestMethod.POST})
    public String gallery() {
        return "gallery";
    }
}
