/**
 * (c) 2013 by SAP AG
 */
package com.sap.core.odata.core.ep.entry;

import java.util.Map;

import com.sap.core.odata.api.ep.entry.EntryMetadata;
import com.sap.core.odata.api.ep.entry.MediaMetadata;
import com.sap.core.odata.api.ep.entry.ODataEntry;
import com.sap.core.odata.api.uri.ExpandSelectTreeNode;
import com.sap.core.odata.core.uri.ExpandSelectTreeNodeImpl;

/**
 * @author SAP AG
 */
public class ODataEntryImpl implements ODataEntry {

  private Map<String, Object> data;
  private EntryMetadata entryMetadata;
  private MediaMetadata mediaMetadata;
  private ExpandSelectTreeNode expandSelectTree;
  private boolean containsInlineEntry;

  public ODataEntryImpl(final Map<String, Object> data, final MediaMetadata mediaMetadata, final EntryMetadata entryMetadata) {
    this(data, mediaMetadata, entryMetadata, false);
  }

  public ODataEntryImpl(final Map<String, Object> data, final MediaMetadata mediaMetadata, final EntryMetadata entryMetadata, final boolean containsInlineEntry) {
    this.data = data;
    this.entryMetadata = entryMetadata;
    this.mediaMetadata = mediaMetadata;
    expandSelectTree = new ExpandSelectTreeNodeImpl();
    this.containsInlineEntry = containsInlineEntry;
  }

  @Override
  public Map<String, Object> getProperties() {
    return data;
  }

  @Override
  public MediaMetadata getMediaMetadata() {
    return mediaMetadata;
  }

  @Override
  public EntryMetadata getMetadata() {
    return entryMetadata;
  }

  @Override
  public boolean containsInlineEntry() {
    return containsInlineEntry;
  }

  @Override
  public ExpandSelectTreeNode getExpandSelectTree() {
    return expandSelectTree;
  }

  public void setContainsInlineEntry(final boolean containsInlineEntry) {
    this.containsInlineEntry = containsInlineEntry;
  }

  public void setExpandSelectTree(final ExpandSelectTreeNode expandSelectTree) {
    this.expandSelectTree = expandSelectTree;
  }

  @Override
  public String toString() {
    return "ODataEntryImpl [data=" + data + ", "
        + "entryMetadata=" + entryMetadata + ", "
        + "mediaMetadata=" + mediaMetadata + ", "
        + "expandSelectTree=" + expandSelectTree + ", "
        + "containsInlineEntry=" + containsInlineEntry + "]";
  }
}
