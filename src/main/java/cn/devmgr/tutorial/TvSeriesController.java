package cn.devmgr.tutorial;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {
    // 日志
    private final Log log = LogFactory.getLog(TvSeriesController.class);

    //    @RequestMapping(method = RequestMethod.GET, value = "")
    @GetMapping
    public List<TvSeriesDto> getAll() {
        if (log.isTraceEnabled()) {
            log.trace("getAll() 被调用了!");
        }
        List<TvSeriesDto> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        list.add(new TvSeriesDto(1, "西部世界", 1, calendar.getTime()));
        calendar.set(2010, Calendar.OCTOBER, 2, 0, 0);
        list.add(new TvSeriesDto(1, "无耻之徒", 9, calendar.getTime()));
        return list;
    }


    @GetMapping("/{id}")
    public TvSeriesDto getOne(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne " + id);
        }
        if (id == 101) {
            return createWestWorld();
        } else if (id == 102) {
            return createPoi();
        } else throw new ResourceNotFoundException();
    }

    private TvSeriesDto createPoi() {
        Calendar c = Calendar.getInstance();
        c.set(2011, Calendar.SEPTEMBER, 22, 0, 0, 0);
        return new TvSeriesDto(102, "Person Of Interest", 5, c.getTime());
    }

    private TvSeriesDto createWestWorld() {
        Calendar c = Calendar.getInstance();
        c.set(2011, Calendar.SEPTEMBER, 22, 0, 0, 0);
        return new TvSeriesDto(101, "WestWorld", 2, c.getTime());
    }
}
